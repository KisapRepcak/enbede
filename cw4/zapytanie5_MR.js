var map = function () {
    if (!this.credit) return;
  
    this.credit.forEach(function (credit) {
      emit(credit.currency, {
        count: 1,
        balance: parseFloat(credit.balance) || 0,
      });
    });
  };
  
  var reduct = function (key, values) {
    var reductedValue = {
      count: 0,
      balance: 0,
    }
  
    values.forEach(function (value) {
      reductedValue.count += value.count;
      reductedValue.balance += value.balance;
    });
  
    return reductedValue;
  }
  
  var final = function (key, reductedValue) {
    reductedValue.avg = (reductedValue.balance / reductedValue.count).toFixed(2);
    reductedValue.sum = reductedValue.balance;
    delete reductedValue.balance;
    return reductedValue;
  }
  
db.people.mapReduce(map, reduct, {query: {"nationality": "Poland", "sex": "Female"}, out: "people5", finalize: final});
printjson(db.people5.find().sort({_id: 1}).toArray())