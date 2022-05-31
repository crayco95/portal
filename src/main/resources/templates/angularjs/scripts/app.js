'use strict';

var app = angular.module('PracticaAngularjs', [
	'ui.router'
])

app.config(function($stateProvider, $urlRouterProvider){
	
	$stateProvider
		.state('students',{
			url:'/students',
			templateUrl:'views/students.html',
			controller: 'StudentController',
			controllerAs: 'student'
		});
	$urlRouterProvider.otherwise('/students');
});