printjson(db.people.aggregate({$group: {_id: "$job"}}).map(function (r){ return r._id; }))