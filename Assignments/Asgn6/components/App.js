// built off of a react app found here: http://tutorialzine.com/2015/04/first-webapp-react/

var React = require('react');
var AddDormitory = require('./AddDormitory');
var AllDormitories = require('./AllDormitories');

var App = React.createClass({


	getInitialState(){

	    return {
		/* TODO: set curpage to 'create' */
		
		};
	},

	shouldComponentUpdate(nextProps, nextState) {
		return nextState !== this.state;
	},


	render(){

		return (
			<div>
				<div className="header">
					<div className="title">DORM LIST</div>
					<table className="nav-bar">
						<td><button className="nav-item create" onClick={() => {this.setState({curpage: 'create'})}} style={this.state.curpage==='create' ? { color: 'white', backgroundColor: '#7C9E0E' } : { color : '#7C9E0E', backgroundColor: 'white' }}>NEW DORM</button></td>
						<td><button className="nav-item getall" onClick={() => {this.setState({curpage: 'getall'})}} style={this.state.curpage==='getall' ? { color: 'white', backgroundColor: '#7C9E0E' } : { color : '#7C9E0E', backgroundColor: 'white' }}>ALL DORMS</button></td>
					</table>
				</div>
				{(this.state.curpage === 'create') ? <AddDormitory /> : <AllDormitories />}
			</div>

		);
	}

});

module.exports = App;
