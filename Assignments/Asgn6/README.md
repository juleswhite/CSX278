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

## Installation

- JHipster already installed and configured from previous tutorial
  - Follow [these instructions](http://stackoverflow.com/questions/36142155/cors-origin-spring-boot-jhipster) to make sure that CORS is disabled for JHipster
- You’ll need an http server installed to run this application
  - Install [Node.js](https://nodejs.org/en/) (THE LATEST VERSION), then open up a terminal and run `npm install -g http-server`. This will download and install an http server you can use for this tutorial.
- Make a directory for the application and run `http-server -p 9090` in that directory to start serving files on localhost:9090
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

## Specifications

- The finished app should interact with a preexisting JHipster server to perform Create/ Read/ Update/ Destroy operations on the underlying database.
- Data from JHipster will be formatted as an array of JSON objects (each representing one student), as follows:

```json
[ {
 "id" : 1,
 "fullName" : "Harrison Stall",
 "emailAddress" : "hstall2529",
 "phoneNumber" : "8645461688",
 "graduationDate" : "2018-05-11",
 "preferredcontact" : {
   "id" : 3,
   "nameOfChoice" : "Facebook"
 },
 "school" : {
   "id" : 1,
   "schoolName" : "Engineering"
 },
 "dorm" : {
   "id" : 2,
   "dormName" : "Off-campus"
 }
} ]
```

- This should give you a good idea of which fields you’ll need to add to the React application. Specifically, make sure you can read and write to the `fullName`, `emailAddress`, `phoneNumber`, `graduationDate`, `preferredcontact`, `school`, and `dorm` fields.
- The application should consist of two screens: one for getting a list of all students, and one for adding a new student to the database. Two buttons will be used for switching between them.
- For reference, here’s our standard application: 

![image of app](http://i.imgur.com/n9hEXQQ.png)




## Acknowledgement

Our reading materials were selected based on Frederick's recommendation of YouTube video and looking at Facebook documentation (the authors of React).
We also chose a highly shared article on Scotch.io and a cartoon on Medium which provides a graphical representation of how Flux and React work together.
The date of publication/ last update for each resource was checked to ensure that all information is recent.

## Team Members

- Santaguida,John S
- Stahl,Joseph
- Stall,Harrison R
- Weitendorf,Frederick D
- Yeonas,Victoria Trent
- Roth,Brittany D
- Kanai,Yoko M
- Weber, Betsy