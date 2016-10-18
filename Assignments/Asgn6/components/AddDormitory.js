var React = require('react');

var AddDormitory = React.createClass({

    getInitialState() {
        return {
	    /* TODO: set dormName to 'default_dorm' */
           
        };
    },

    handleName(event) {
	/* TODO: set the state of dormName to 'event.target.value' Hint: use this.setState({...}) */
       
    },

    handleId(event) {
	/* TODO: set the state of dormID to 'event.target.value', similar to above */
     
    },


    handleSubmit(event){
        console.log(this.state);
        event.preventDefault();
        var reqstring = JSON.stringify(this.state);
        console.log(reqstring);
        // Unfocus the text input field
        $.ajax({
            type: /* TODO: set 'type' to either GET or POST */,
            url: 'http://localhost:8080/api/dormitories',
            dataType: 'json',
            contentType: 'application/json',
            data: reqstring
        }).done(function(data) {
            console.log('You made a new dorm!');
            alert('You have created a new dorm!');
        }).fail(function(jqXhr) {
            console.log('failed to register');
            alert('You could not create a new dorm.');
        });
    },

    render() {
        console.log('Interacted with \'NEW DORM\' panel');
        return (
            <form id="search-form" onSubmit={this.handleSubmit}>
                <div className="form-group">
                    <div className="input-group">
                        <input type="text" id="dormName" placeholder="Dorm name" 
                        value={this.state.dormName} onChange={this.handleName} /><br/>
                        
                    </div>
                </div>
                <button type="submit" onClick="handleSubmit">Submit</button>
            </form>
        );
    }
});

module.exports = AddDormitory;
