/**
 * Created by Peter on 9/22/16.
 */

//Intitializing elastic search client
var elasticsearch = require('elasticsearch');
var client = new elasticsearch.Client({
    host: 'localhost:9200',
    log: 'trace'
});

//Creating Bond Movie JSONs
dr_no = {title: "Dr. No", year: 1962, bond: "Sean Connery", director: "Terence Young"};
from_russia_with_love = {title: "From Russia With Love", year: 1963, bond: "Sean Connery", director: "Terence Young"};
goldfinger = {title: "Goldfinger", year: 1964, bond: "Sean Connery", director: "Guy Hamilton"};
thunderball = {title: "Thunderball", year: 1965, bond: "Sean Connery", director: "Terence Young"};
casino_royale = {title: "Casino Royale", year: 1967, bond: "David Niven", director: "Ken Hughes"};
you_only_live_twice = {title: "You Only Live Twice", year: 1967, bond: "Sean Connery", director: "Lewis Gilbert"};
on_her_majestys_secret_service = {title: "On Her Majesty's Secret Service", year: 1969, bond: "George Lazenby", director: "Peter Hunt"};
diamonds_are_forever = {title: "Diamonds Are Forever", year: 1971, bond: "Sean Connery", director: "Guy Hamilton"};
live_and_let_die = {title: "Live and Let Die", year: 1973, bond: "Roger Moore", director: "Guy Hamilton"};
the_man_with_the_golden_gun = {title: "The Man with the Golden Gun", year: 1974, bond: "Roger Moore", director: "Guy Hamilton"};
the_spy_who_loved_me = {title: "The Spy Who Loved Me", year: 1977, bond: "Roger Moore", director: "Lewis Gilbert"};
moonraker = {title: "Moonraker", year: 1979, bond: "Roger Moore", director: "Lewis Gilbert"};
for_your_eyes_only = {title: "For Your Eyes Only", year: 1981, bond: "Roger Moore", director: "John Glen"};
octopussy = {title: "Octopussy", year: 1983, bond: "Roger Moore", director: "John Glen"};
never_say_never_again = {title: "Never Say Never Again", year: 1983, bond: "Sean Connery", director: "Irvin Kershner"};
a_view_to_a_kill = {title: "A View to a Kill", year: 1985, bond: "Roger Moore", director: "John Glen"};
the_living_daylights = {title: "The Living Daylights", year: 1987, bond: "Timothy Dalton", director: "John Glen"};
licence_to_kill = {title: "Licence to Kill", year: 1989, bond: "Timothy Dalton", director: "John Glen"};
goldeneye = {title: "GoldenEye", year: 1995, bond: "Pierce Brosnan", director: "Martin Campbell"};
tomorrow_never_dies = {title: "Tomorrow Never Dies", year: 1997, bond: "Pierce Brosnan", director: "Roger Spottiswoode"};
the_world_is_not_enough = {title: "The World Is Not Enough", year: 1999, bond: "Pierce Brosnan", director: "Michael Apted"};
die_another_day = {title: "Die Another Day", year: 2002, bond: "Pierce Brosnan", director: "Lee Tamahori"};
casino_royale2 = {title: "Casino Royale", year: 2006, bond: "Daniel Craig", director: "Martin Campbell"};
quantum_of_solace = {title: "Quantum of Solace", year: 2008, bond: "Daniel Craig", director: "Marc Forster"};
skyfall = {title: "Skyfall", year: 2012, bond: "Daniel Craig", director: "Sam Mendes"};
spectre = {title: "Spectre", year: 2015, bond: "Daniel Craig", director: "Sam Mendes"};

//addMovie1();
//setTimeout(addBondMovies, 1000);
//setTimeout(createTest, 2000);
//setTimeout(deleteTest, 3000);
//setTimeout(queryAll, 4000);
//setTimeout(getID1, 5000);
//setTimeout(queryKill, 6000);
//setTimeout(query1967, 7000);
//setTimeout(queryCasino1967, 8000);
//setTimeout(changeMapping, 9000);
//setTimeout(addBondMovies, 10000);
//setTimeout(queryGuyHamilton_2, 13000);



//Populating "movies" index w/ all of the bond movie JSONs
//Using create() for first and bulk() to combine all other operations into a single request
function addMovie1(){
    client.create({
        index: "movies",
        type: "bond_movie",
        id: "1",
        body: dr_no
    });
}

function addBondMovies(){

}

//Creating a test index and adding a document
function createTest() {

}

//Deleting the document from the test index
function deleteTest() {

}

//Query that returns all bond movies
function queryAll() {

}

//Query that returns the bond movie with an ID of 1
function getID1(){

}

//Query_string query that returns all bond movies that have the word "kill" somewhere in their JSON body
function queryKill(){

}

//Term query that returns all bond movies that were made in the year 1967
function query1967(){

}

//Filtered query that returns all bond movies with the term "Casino Royale" that were made in the year 1967
function queryCasino1967(){

}

//Term query that attempts to return all movies directed by Guy Hamilton but fails to do so
function queryGuyHamilton_1(){
    client.search({
        index: "movies",
        type: "bond_movie",
        body: {
            query: {
               term: {
                   director: "Guy Hamilton"
               }
            }
        }
    })
}

//Function that changes the mapping of documents with type "bond_movie" so that director is a multi_field with one of the fields being unanalyzed/prcessed before being indexed
function changeMapping(){

}

//Term query that successfully returns all movies directed by Guy Hamilton following a successful change in mapping using changeMapping()
function queryGuyHamilton_2(){
    client.search({
        index: "movies",
        type: "bond_movie",
        body: {
            query: {
                term: {
                    "director.original": "Guy Hamilton"
                }
            }
        }
    })
}