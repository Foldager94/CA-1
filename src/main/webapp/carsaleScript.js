
console.log("Script running carsaleScript");

var url = "api/car/all";


function reloadCars(){
    fetch(url)
            .then(res => res.json()) //in flow1, just do it
            .then(lis => {
                // Inside this callback, and only here, the response data is available
                console.log("data", lis);
                /* data now contains the response, converted to JavaScript
                 Observe the output from the log-output above
                 Now, just build your DOM changes using the data*/


                var tableHead = "<thead><tr>" +
                        "<th>ID</th>" +
                        "<th>Make</th>" +
                        "<th>Model</th>" +
                        "<th>Year</th>" +
                        "<th>Price</th>" +
                        "</tr></thead>";

                function loadArray(lis) {
                    var stringObj = "<td>" + lis.id + "</td><td>" + lis.make + "</td><td>" + lis.model + "</td><td>" + lis.year + "</td><td>" + lis.price + "</td>";
                    return "<tr>" + stringObj + "</tr>";
                }

                function postTable(tableBody) {
                    document.getElementById("list").innerHTML = tableHead + "<tbody>" + tableBody + "</tbody>";
                }

                postTable(lis.map(loadArray).join(""));


    //            var htmlString = <thead></thead>
    //
    //
    //            document.getElementById("list").innerHTML = lis

            });}
        reloadCars();
        document.getElementById("button").addEventListener("click", reloadCars);

