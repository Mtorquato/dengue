var map;
var idInfoBoxAberto;
var infoBox = [];
var markers = [];

function initialize() {
    var latlng = new google.maps.LatLng(-18.8800397, -47.05878999999999);

    var options = {
        zoom: 5,
        center: latlng,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };

    map = new google.maps.Map(document.getElementById("mapa"), options);
}

initialize();

function abrirInfoBox(id, marker) {
    if (typeof(idInfoBoxAberto) == 'number' && typeof(infoBox[idInfoBoxAberto]) == 'object') {
        infoBox[idInfoBoxAberto].close();
    }

    infoBox[id].open(map, marker);
    idInfoBoxAberto = id;
}

function BrunoViadoId(id) {           
    
    document.getElementById("idMarker").innerHTML = "<input type='hidden' name='idMarkerStatus' value='" + id + "' />";
}

function capturavalor(description){
    
    document.getElementById("markerDescription").innerHTML = "<h4>" + description + "</h4>";
}

function carregarPontos() {

    $.getJSON('js/pontos.json', function(pontos) {

        var latlngbounds = new google.maps.LatLngBounds();

        $.each(pontos, function(index, ponto) {


            var marker = new google.maps.Marker({
                position: new google.maps.LatLng(ponto.latitude, ponto.longitude),
                title: "" + ponto.valor + "",
                icon: '' + ponto.icone + '',
                id: '' + ponto.id + '',
            });



            var myOptions = {
                content: "<p>" + ponto.valor + "</p>",
                pixelOffset: new google.maps.Size(-150, 0)
            };

            infoBox[ponto.id] = new InfoBox(myOptions);
            infoBox[ponto.id].marker = marker;

            infoBox[ponto.id].listener = google.maps.event.addListener(marker, 'click', function(e) {
                abrirInfoBox(ponto.id, marker);
                BrunoViadoId(ponto.id);
                capturavalor(ponto.valor);
            });

            markers.push(marker);

            latlngbounds.extend(marker.position);

        });

        var markerCluster = new MarkerClusterer(map, markers);

        map.fitBounds(latlngbounds);

    });

}

carregarPontos();