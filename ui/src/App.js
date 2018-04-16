import React, {Component} from 'react';
import Chess from 'react-chess'
import './App.css';

const defaultLineup = ['N@a1', 'n@b1']

class Moves extends Component {
    render() {
        return (
            "a1 b2 c3"
        );
    }
}

class App extends Component {
    constructor(props) {
        super(props)

        this.state = {pieces: defaultLineup, callToServer: false, moves: null}
        this.handleMovePiece = this.handleMovePiece.bind(this)
        this.renderMoves = this.renderMoves.bind(this)
        this.handleDragStart = this.handleDragStart.bind(this)
        this.fetchMoves = this.fetchMoves.bind(this)
    }

    handleDragStart(piece, fromSquare) {
        return !this.state.callToServer

    }

    fetchMoves() {
        const {pieces} = this.state
        if (pieces.length != 2) {
            console.debug("Incorrect state", pieces)
            return
        }
        var start = null
        var end = null
        if (pieces[0].startsWith("N")) {
            start = pieces[0].substr(2)
            end = pieces[1].substr(2)
        } else {
            start = pieces[1].substr(2)
            end = pieces[0].substr(2)
        }

        this.setState({callToServer: true})
        const outerThis = this

        fetch("http://localhost:8080/path/knight?start=" + start + "&end=" + end).then(function (response) {
            if (response.status >= 200 && response.status < 300) {
                return Promise.resolve(response)
            } else {
                return Promise.reject(new Error(response.statusText))
            }
        }).then(function (response) {
            return response.json()
        }).then(function (json) {
            var moves = null
            if (Array.isArray(json)) {
                moves = json[0]
            }
            outerThis.setState({callToServer: false, moves: moves})
        }).catch(function (error) {
            console.log('Request failed', error);
            outerThis.setState({callToServer: false})
        })
    }

    handleMovePiece(piece, fromSquare, toSquare) {
        const newPieces = this.state.pieces
            .map((curr, index) => {
                if (piece.index === index) {
                    return `${piece.name}@${toSquare}`
                } else if (curr.indexOf(toSquare) === 2) {
                    return false // To be removed from the board
                }
                return curr
            })
            .filter(Boolean)

        this.setState({pieces: newPieces})
    }


    renderMoves() {
        if (this.state.moves != null) {
            const {moves} = this.state
            return <div className="Moves">
                Fastest path are: {moves.join(" ")}
            </div>
        }
        return <div className="Moves">
            Path not found
        </div>
    }

    render() {
        const {pieces} = this.state
        return (
            <div className="App">
                <div className="Board">
                    <p>Move figures to board. White knight is start point. Black knight is end point.</p>
                    <p>After you choose start and end position, please click 'Calculate moves' button</p>
                    <button onClick={this.fetchMoves}>Calculate moves</button>
                    <Chess pieces={pieces} onMovePiece={this.handleMovePiece} onDragStart={this.handleDragStart}/>
                </div>
                {this.renderMoves()}
            </div>
        );
    }
}

export default App;
