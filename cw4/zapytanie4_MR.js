var map = function () {
    var BMI = function (weight, height) {
      return (weight / Math.pow(height / 100, 2));
    }
  
    var weight = parseFloat(this.weight);
    var height = parseFloat(this.height);
  
    emit(this.nationality, {
      count: 1,
      sum: BMI(weight, height),
      min: BMI(weight, height),
      max: BMI(weight, height),
    });
  };
  
  var reduct = function (key, values) {
    var reductedValue = {
      count: 0,
      sum: 0,
      min: values[0].min,
      max: values[0].max,
    }
  
    values.forEach(function (value) {
      reductedValue.count += value.count;
      reductedValue.sum += value.sum;
      reductedValue.min = Math.min(reductedValue.min, value.min);
      reductedValue.max = Math.max(reductedValue.max, value.max);
    });
  
    return reductedValue;
  }
  
  var final = function (key, reductedValue) {
    reductedValue.avg = reductedValue.sum / reductedValue.count;
    delete reductedValue.sum;
    return reductedValue;
  }
  
printjson(db.people.mapReduce(map, reduct, {out: 'people4', finalize: final}));
printjson(db.people4.find().sort({_id: 1}).toArray())