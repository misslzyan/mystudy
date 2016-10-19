function PhoneListCtrl($scope){
	$scope.phones=[
	   {"name":"Nexus S1","snippet":"Fast1","age":2},
	   {"name":"Nexus S2","snippet":"Fast2","age":1},
	   {"name":"Nexus S3","snippet":"Fast3","age":0}
	];
	$scope.orderProp="age";
}