    var map, searchManager;
    function GetMap() {
        map = new Microsoft.Maps.Map('#myMap', {
			center: new Microsoft.Maps.Location(23.0225, 72.5714)
		});
    }
    function setMap()
    {
        var greenPin = new Microsoft.Maps.Pushpin(new Microsoft.Maps.Location(23.0225, 72.5714), { color: '#0f0', draggable: true });
        map.entities.push(greenPin);
        Microsoft.Maps.Events.addHandler(greenPin, 'drag', function (e) { highlight('pushpinDrag', e); });
    }   
    
    function highlight(id, event) {
        //Highlight the mouse event div to indicate that the event has fired.
        //document.getElementById(id).style.background = 'LightGreen';
       // document.getElementById('pushpinLocation').value = event.target.getLocation().toString();
		 document.getElementById('longitude').value = event.target.getLocation().latitude.toString();
		 document.getElementById('latitude').value = event.target.getLocation().longitude.toString();
        //Remove the highlighting after a second.
        setTimeout(function () { document.getElementById(id).style.background = 'white'; }, 1000);
    }
    function Search() {
        if (!searchManager) {
            //Create an instance of the search manager and perform the search.
            Microsoft.Maps.loadModule('Microsoft.Maps.Search', function () {
                searchManager = new Microsoft.Maps.Search.SearchManager(map);
                Search()
            });
        } else {
            //Remove any previous results from the map.
            map.entities.clear();
            //Get the users query and geocode it.
            var query = document.getElementById('searchTbx').value;
            setMap();
            geocodeQuery(query);
        }
    }
    function geocodeQuery(query) {
        var searchRequest = {
            where: query,
            callback: function (r) {
                if (r && r.results && r.results.length > 0) {
                    var pin, pins = [], locs = [], output = 'Results:<br/>';
                    for (var i = 0; i < r.results.length; i++) {
                        //Create a pushpin for each result. 
                        pin = new Microsoft.Maps.Pushpin(r.results[i].location, {
                            text: i + ''
                        });
                        pins.push(pin);
                        locs.push(r.results[i].location);
                        output += i + ') ' + r.results[i].name + '<br/>';
                    }
                    //Add the pins to the map
                    map.entities.push(pins);
                 
                   //Display list of results
                   // document.getElementById('output').innerHTML = output;
                    //Determine a bounding box to best view the results.
                    var bounds;
                    if (r.results.length == 1) {
                        bounds = r.results[0].bestView;
                    } else {
                        //Use the locations from the results to calculate a bounding box.
                        bounds = Microsoft.Maps.LocationRect.fromLocations(locs);
                    }
                    map.setView({ bounds: bounds });
                }
               
                
            },
            errorCallback: function (e) {
                //If there is an error, alert the user about it.
                alert("No results found.");
            }
        };
        //Make the geocode request.
        searchManager.geocode(searchRequest);
        
    
    }
    