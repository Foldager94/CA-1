console.log("Script running JokeScript");

let url = "api/joke/all";
let url2 = "api/joke/";
let url4 = "api/joke/random";
function reloadJokes() {

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
                        "<th>Joke</th>" +
                        "<th>Type</th>" +
                        "</tr></thead>";

                function loadArray(lis) {
                    var stringObj = "<td>" + lis.id + "</td><td>" + lis.joke + "</td><td>" + lis.type + "</td>";
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

            });
}
;

document.getElementById("myBtn1").addEventListener("click", function byID() {
    let id = document.getElementById("myInput").value;
    let url3 = url2 + id;
    fetch(url3)
            .then(res => res.json())
            .then(movie => {
                document.getElementById("list").innerHTML = "<p style='font-size:200%; font-family:cursive;'>" + movie.joke + "</p>";
                document.getElementById("jokeid").innerHTML = "Joke " + id;
            });
    ;
});

document.getElementById("myBtn2").addEventListener("click", function randomJokeByID() {
    fetch(url4)
            .then(res => res.json())
            .then(count => {
                            document.getElementById("list").innerHTML = "<p style='font-size:200%; font-family:cursive;'>" + count.joke + "</p>";
                            document.getElementById("jokeid").innerHTML = "Joke " + count.id;
                        });
            });


reloadJokes();
document.getElementById("button").addEventListener("click", reloadJokes);


