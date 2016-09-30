// built off of a react app found here: http://tutorialzine.com/2015/04/first-webapp-react/

var React = require('react');
var AddStudent = require('./AddStudent');
var AllStudents = require('./AllStudents');

var App = React.createClass({


	getInitialState(){

		return {
			curpage: 'create'
		};
	},

	shouldComponentUpdate(nextProps, nextState) {
		return nextState !== this.state;
	},


	render(){
		return (

			<div>
				<div className="header">
					<div className="title">STUDENT ROSTER</div>
					<table className="nav-bar">
						<td><button className="nav-item create" onClick={() => {this.setState({curpage: 'create'})}}>NEW STUDENT</button></td>
						<td><button className="nav-item getall" onClick={() => {this.setState({curpage: 'getall'})}}>ALL STUDENTS</button></td>
					</table>
				</div>
				{(this.state.curpage === 'create') ? <AddStudent /> : <AllStudents />}
			</div>

		);
	}

});

module.exports = App;