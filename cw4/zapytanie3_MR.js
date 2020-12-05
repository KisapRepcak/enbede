var map = function () {
    emit(this.job, {
      amountW: 1
    });
  };


var reduct = function (key, values) {
    var reducted = {
      amountW: 0
    };

    values.forEach(function (value) {
      reducted.amountW += value.amountW;
    });

    return reducted;
  };


db.people.mapReduce(map, reduct, {out: "people3"});
printjson(db.people3.find().sort({_id: 1}).toArray());