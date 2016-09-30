var React = require('react');

var AllStudents = React.createClass({

    componentWillMount() {
        var reqdata = {};
        console.log('hello');
        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/api/students'
        }).done(function(data) {
            reqdata = data;
            console.log(JSON.stringify(data));
        }).fail(function(jqXhr) {
            console.log('failed to access');
        });
        this.setState(reqdata);
    },

    render() {

        return (
            <p></p>
        );
    }
});

module.exports = AllStudents;