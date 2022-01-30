![alt text](https://github.com/jokereey/MedicumZone/blob/main/src/ui/medicumzone-ui/src/assets/images/Medicum-Zone-logos_transparent.png?raw=true)
# Medicum-Zone

Medicum-Zone is an application created for managing doctor appointments. Besides that, a user can perform other actions, like rating doctors, checking the latest covid stats and many other.
The application is being developed for learning purposes.

## Stack
- Spring Boot 2.5.5
- Angular 13

## Features
### Current:
- Arranging medical appointemnts
- Sign-up / Sign-in actions
- fetching the latest covid statistics
### To-do
- Recommendation system
- Newsletter api
- Downloading Laboratory investigation results
- Sms and mail reminders

## Installation

Medicum-Zone requires [Node.js](https://nodejs.org/) v10+ to run.
Node.js would be enough to run the front-end part.
Firstly, clone repo:
```sh
git clone https://github.com/jokereey/MedicumZone.git
```
After cloinnig the repo, in the root folder, do as follows:
```sh
npm install
npm start
```
If you want to run mock server, do as follows:
```sh
cd src/mock
json-server api.json --routes routes.json --watch
```
You can also select the port adding --port to the command.
For now, there is no possibility to run backend manually. It requires setting up the database.
In the future we will use **docker** (as long as the app is not deployed anywhere).

