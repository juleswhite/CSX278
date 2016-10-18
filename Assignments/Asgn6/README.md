## React Reading (before 10/18)

- [Getting Started with React.js](https://www.youtube.com/watch?v=68NzBI6RRKE)
- [Learning React.js: Getting Started and Concepts](https://scotch.io/tutorials/learning-react-getting-started-and-concepts)
- [Thinking in React](https://facebook.github.io/react/docs/thinking-in-react.html)
  - [Why React?](https://facebook.github.io/react/docs/why-react.html)
  - Read from "Why React?" to "Transferring Props"
- [A Cartoon Guide to Flux](https://code-cartoons.com/a-cartoon-guide-to-flux-6157355ab207#.xgg3sdvgr)
- [How React Components Make UI Testing Easy](https://www.toptal.com/react/how-react-components-make-ui-testing-easy)

### For reference, the following readings are optional

- [Mozilla Developer Network: the DOM](https://developer.mozilla.org/en-US/docs/Web/API/Document_Object_Model/Introduction/)
- [Eloquent JavaScript](http://eloquentjavascript.net/)

## Pre-Class Assignment

To verify that you have downloaded everything before class, use the command `node –v` and fill out the following [form](https://docs.google.com/a/vanderbilt.edu/forms/d/e/1FAIpQLSd6R25o04TA2Z9MfowATtHjJ_FbgfBjXwexXzLfBrxOD7Xkwg/viewform?c=0&w=1) with the output of the command.

Also, make sure that you can still run the JHipster application from assignment 1. Make the security changes (look in Security section)

## Installation

- JHipster already installed and configured from previous tutorial
- You’ll need an http server installed to run this application
  - Install [Node.js](https://nodejs.org/en/) (THE LATEST VERSION), then open up a terminal and run `npm install -g http-server`. This will download and install an http server you can use for this tutorial.
- Sync your class folder to get the latest version of Assignment 6. Once you've updated the folder, cd to the Asgn6 directory and run `npm install` to install the various prerequisites. 
- Run `http-server -p 9090` in that directory to start serving files on localhost:9090
  - This should make `index.html` available at `localhost:9090` in your web browser.
  - **THIS IS IMPORTANT! JHipster runs on 8080 so our React app will have to run on a different port.**

### Downloading and Installing Webstorm

*If you already have an IDE that you use for Javascript, no need to download WebStorm. If you don’t want to download an IDE solely for this assignment, feel free to use a text editor*

1. Go to [https://www.jetbrains.com/webstorm/](https://www.jetbrains.com/webstorm/) and click download in the upper right corner
2. On the next screen, select your platform and click download
3. On the install screen, click next then select the location for download (default should be fine)
4. Then, select a desktop shortcut if you so wish, and do not check any boxes for the associations
5. Allow the default start menu folder and click install!
6. First time you open WebStorm:
  - Select the “I do not have a previous version of Webstorm or I do not want to import my settings box”
  - If you already use Jet Brains products, your license should automatically transfer over and WebStorm will open with no issues
  - If you don’t have a Jet Brains account, you’ll need to get a classroom license by visiting [https://www.jetbrains.com/shop/eform/students](https://www.jetbrains.com/shop/eform/students) and entering your vanderbilt email

## Changes to JHipster

- Go to the `SecurityConfiguration.java` file in your JHipster project (found in `/src/main/java/com/theNameYouChose/jhipster/config`) and change the `configure (HttpSecurity  http)` method so reads as the following:

```java
@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests().anyRequest().permitAll();
    }
```

- Go to the `application.yml` file (in `/src/main/resources/config`) and uncomment the following:

```
cors: #By default CORS are not enabled. Uncomment to enable.
        allowed-origins: "*"
        allowed-methods: GET, PUT, POST, DELETE, OPTIONS
        allowed-headers: "*"
        exposed-headers:
        allow-credentials: true
        max-age: 1800
```

- Run `npm i` and `npm build` 

## Specifications

- The finished app should interact with a preexisting JHipster server to perform Create/ Read/ Update/ Destroy operations on the underlying database.
For simplicity, we'll only cover Read (GET) and Create (POST) operations in this assignment.
- We'll only interact with the Dormitory API from Assignment 1, at the path `/api/dormitory`.

```json
[
  { "id": 0, "dormName": "TestDorm" }
]
```

- This should give you a good idea of which fields you’ll need to add to the React application.
  - Keep in mind that the `id` field will be populated automatically. Therefore, you'll only need to fill in a "dormName" field for POST requests.
- The application will consist of two screens: on one, you can enter the name of a dorm and POST it to the API; on the second, you'll GET a list of all dorms.
- We’ve provided skeleton code for most of the application. You are responsible for creating POST requests and creating a table in HTML following a GET request.
  - Hint: this method should return JSX that React can use to create a table.

For reference, here's our implementation:

![reference](http://i.imgur.com/REjWWEB.png)

## Completing the assignment

Look at the `.createClass()` functions in the `AllDormitories.js` and `AddDormitory.js` files and add your code to the return method.
There's also a single item to do in `App.js`.
We've added `//TODO` statements to indicate where you should make changes.

**To run the application, first run `npm script build`.** This will package the various JS files together to be served to the web browser.
Once this is done, kill/ restart the HTTP server (`http-server -p 9090`) and reload the web page.
Also, make sure that JHipster is running so that you have an API to interact with.

Run the application, verify that things work, and push the results to your repository.

## Acknowledgement

Our reading materials were selected based on Frederick's recommendation of YouTube video and looking at Facebook documentation (the authors of React).
We also chose a highly shared article on Scotch.io and a cartoon on Medium which provides a graphical representation of how Flux and React work together.
The date of publication/ last update for each resource was checked to ensure that all information is recent.

## Team Members

- Santaguida, John S
- Stahl, Joseph
- Stall, Harrison R
- Weitendorf, Frederick D
- Yeonas, Victoria Trent
- Roth, Brittany D
- Kanai, Yoko M
- Weber, Betsy
