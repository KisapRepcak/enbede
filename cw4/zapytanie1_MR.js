var map = function () {
	emit(this.sex, {
	count: 1,
	height: parseFloat(this.height),
	weight: parseFloat(this.weight)})};
	
	var reduct = function (key, values) {
	var reductedValue = {
	count: 0,
	height: 0,
	weight: 0};
	
	values.forEach(function (value) {
	reductedValue.count += value.count;
	reductedValue.height += value.height;
	reductedValue.weight += value.weight});
	
	return reductedValue};
	
	var finalizer = function (key, reductedValue) {
	reductedValue.height = reductedValue.height / reductedValue.count;
	reductedValue.weight = reductedValue.weight / reductedValue.count;
	return reductedValue};
	
db.people.mapReduce(map, reduct, {out: 'people1', finalize: finalizer});
printjson(db.people1.find().sort({_id: 1}).toArray());