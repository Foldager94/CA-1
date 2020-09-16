console.log("Script running");
//var url = "https://vd52024.dk/CA-1/api/member/all"
var url = "api/member/all";


function reloadMembers(){
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
                        "<th>Navn</th>" +
                        "<th>Favorit Slik</th>" +
                        "</tr></thead>"

                function loadArray(lis) {
                    var stringObj = "<td>" + lis.id + "</td><td>" + lis.navn + "</td><td>" + lis.favSlik + "</td>";
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

            })}
        reloadMembers();
        document.getElementById("button").addEventListener("click", reloadMembers)







