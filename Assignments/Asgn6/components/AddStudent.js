var React = require('react');

var AddStudent = React.createClass({

    getInitialState() {
        return {
            fullName: '',
            emailAddress: '',
            phoneNumber: '',
            month: '01',
            year: '2017',
            graduationDate: '2017-01-15',
            preferedcontact: '1',
            school: '1',
            dorm: '1'
        };
    },

    handleName(event) {
        this.setState({fullName: event.target.value});
        console.log(this.state);
    },

    handleEmail(event) {
        this.setState({emailAddress: event.target.value});
    },

    handlePhone(event) {
        this.setState({phoneNumber: event.target.value});
    },

    handleMonth(event) {
        this.setState({graduationDate: (this.state.year + '-' + event.target.value + '-15')});
    },

    handleYear(event) {
        this.setState({graduationDate: (event.target.value + '-' + this.state.month + '-15')});
    },

    handleContact(event) {
        this.setState({preferedcontact: event.target.value});
    },

    handleSchool(event) {
        this.setState({school: event.target.value});
    },

    handleDorm(event) {
        this.setState({dorm: event.target.value});
    },

    handleSubmit(event){
        console.log(this.state);
        event.preventDefault();
        var reqstring = JSON.stringify(this.state);

        // Unfocus the text input field
        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/api/students',
            dataType: 'json',
            contentType: 'application/json',
            data: reqstring
        }).done(function(data) {
            console.log('new student')
        }).fail(function(jqXhr) {
            console.log('failed to register');
        });
    },

    render() {

        return (
            <form id="search-form" onSubmit={this.handleSubmit}>
                <div className="form-group">
                    <div className="input-group">
                        <input type="text" id="fullName" placeholder="Full name" 
                        value={this.state.fullName} onChange={this.handleName} /><br/>
                        <input type="text" id="emailAddress" placeholder="Email address" 
                        value={this.state.emailAddress} onChange={this.handleEmail} /><br/>
                        <input type="text" id="phoneNumber" placeholder="Phone number" 
                        value={this.state.phoneNumber} onChange={this.handlePhone} /><br/>
                        <p>Graduation date</p>
                        <select id="month" value="01" onChange={this.handleMonth}>
                            <option value="01">January</option>
                            <option value="02">February</option>
                            <option value="03">March</option>
                            <option value="04">April</option>
                            <option value="05">May</option>
                            <option value="06">June</option>
                            <option value="07">July</option>
                            <option value="08">August</option>
                            <option value="09">September</option>
                            <option value="10">October</option>
                            <option value="11">November</option>
                            <option value="12">December</option>
                        </select>
                        <select id="year" value="2017" onChange={this.handleYear}>
                            <option value="2017">2017</option>
                            <option value="2018">2018</option>
                            <option value="2019">2019</option>
                            <option value="2020">2020</option>
                        </select>
                        <p>Preferred contact</p>
                        <select id="preferedcontact" value="1" onChange={this.handleContact}>
                            <option value="1">Phone</option>
                            <option value="2">Email</option>
                            <option value="3">Facebook</option>
                        </select>
                        <p>School</p>
                        <select id="school" value="1" onChange={this.handleSchool}>
                            <option value="1">Engineering</option>
                            <option value="2">Peabody</option>
                            <option value="3">Arts & Sciences</option>
                            <option value="4">Blair</option>
                        </select>
                        <p>Dorm</p>
                        <select id="dorm" value="1" onChange={this.handleDorm}>
                            <option value="1">Kissam</option>
                            <option value="2">Off-campus</option>
                            <option value="3">Towers</option>
                        </select>
                    </div>
                </div>
                <button type="submit" onClick="handleSubmit">Submit</button>
            </form>
        );
    }
});

module.exports = AddStudent;