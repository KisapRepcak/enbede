var amount;
var value;

var map = function () {
    if (!this.credit) return;

    this.credit.forEach(function (credit) {
      amount = parseFloat(credit.balance) || 0;
      value = credit.currency;

      emit(value, amount);
    });
    };

var reduct = function (key, values) {
  return Array.sum(values)
  };

db.people.mapReduce(map, reduct, {out: "people2"});
printjson(db.people2.find().sort({_id:1}).toArray());