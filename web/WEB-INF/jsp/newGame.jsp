<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons"/>
    <script type="text/javascript" src="<c:url value="/resources/js/Playground.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/Player.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/Enemy.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/Items.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/Level.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/Game.js"/>"></script>
    <link rel="stylesheet" href="<c:url value="/resources/css/game.css"/>"/>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.2/angular.min.js"></script>
    <script src="https://unpkg.com/react@16/umd/react.production.min.js"></script>
    <script src="https://unpkg.com/react-dom@16/umd/react-dom.production.min.js"></script>
    <script src="https://unpkg.com/babel-standalone@6.15.0/babel.min.js"></script>
</head>

<body onload="setGame()">
<div class="container-fluid">

    <div class="row mt-3 mt-lg-1 ">
        <div class="col-lg-4 col-2 offset-1 offset-lg-0">
            <img src="<c:url value="/resources/img1/computercattivo.png"/>" class="rounded img-fluid rounded float-right"
                 alt="Cinque Terre">
        </div>
        <div class="col-lg-4 col-6">
            <div class="mx-auto d-block">
                <img src="<c:url value="/resources/img1/badware2.png"/>" class="rounded img-fluid rounded mx-auto d-block " alt="Cinque Terre">
            </div>
        </div>
        <div class="col-lg-4 col-2">
            <img src="<c:url value="/resources/img1/computercattivo2.png"/>" class="rounded img-fluid rounded float-left " alt="Cinque Terre">
        </div>
    </div>
    <div class="row my-3" id="gameStatus" hidden>
        <div class="col-lg-4"></div>
        <div class="itemDiv col-lg-1 col-3 offset-lg-4 offset-0 mx-lg-1 ">
            Lifes:
            <b id="lifesValue"></b>
            <i class="material-icons myIcon" style="color:red;">favorite_border</i>
        </div>
        <div class="itemDiv col-lg-1 col-3 offset-lg-4 offset-0 mx-lg-1 ">
            Gems:
            <b id="gemsValue"></b>
            <i class="material-icons myIcon " style="color:green;">monetization_on</i>
        </div>
        <div class="itemDiv col-lg-1 col-3 offset-lg-4 offset-0 mx-lg-1 ">
            Level:
            <b id="level"></b>
            <i class="material-icons myIcon" id="levelIco" style="color:orange;"></i>
        </div>
        <div class="itemDiv col-lg-1 col-3 offset-lg-4 offset-0 mx-lg-1 ">
            Score:
            <b id="score"></b>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-5 offset-lg-3 col-12 ">
            <p>Energy </p>
            <div class="progress ">
                <div class="progress-bar progress-bar-striped progress-bar-animated bg-success" id="progBar"
                     role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="30"></div>
            </div>
        </div>

    </div>
    <div class="row">
        <div class="col-lg-3 col-12 my-2 ">
            <div class="row pt-3">
                <div class="col-lg-6 col-5 offset-1 offset-lg-0">
                    <div class="btn-group-vertical offset-1 ">
                        <!-- Button to Open the Modal -->
                        <button type="button" class="btn btn-warning buttone mr-1" data-toggle="modal"
                                data-target="#myModal">
                            How To Play
                        </button>

                        <!-- The Modal -->
                        <div class="modal fade" id="myModal">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                </div>

                                <!-- Modal body -->
                                <div class="modal-body">
                                    <div id="demo" class="carousel slide" data-ride="carousel">
                                        <ul class="carousel-indicators">
                                            <li data-target="#demo" data-slide-to="1" class="active"></li>
                                            <li data-target="#demo" data-slide-to="2"></li>
                                            <li data-target="#demo" data-slide-to="3"></li>
                                            <li data-target="#demo" data-slide-to="4"></li>
                                            <li data-target="#demo" data-slide-to="5"></li>

                                        </ul>
                                        <div class="carousel-inner">
                                            <div class="carousel-item active">
                                                <img src="<c:url value="/resources/img1/Diapositiva1.JPG"/>" alt="Los Angeles" width="500"
                                                     height="287">
                                                <div class="carousel-caption">

                                                </div>
                                            </div>
                                            <div class="carousel-item">
                                                <img src="<c:url value="/resources/img1/Diapositiva2.JPG"/>" alt="Chicago" width="500"
                                                     height="287">
                                                <div class="carousel-caption">

                                                </div>
                                            </div>
                                            <div class="carousel-item">
                                                <img src="<c:url value="/resources/img1/Diapositiva3.JPG"/>" alt="New York" width="500"
                                                     height="287">
                                                <div class="carousel-caption">

                                                </div>
                                            </div>
                                            <div class="carousel-item">
                                                <img src="<c:url value="/resources/img1/Diapositiva4.JPG"/>" alt="New York" width="500"
                                                     height="287">
                                                <div class="carousel-caption">

                                                </div>
                                            </div>
                                            <div class="carousel-item">
                                                <img src="<c:url value="/resources/img1/Diapositiva5.JPG"/>" alt="New York" width="500"
                                                     height="287">
                                                <div class="carousel-caption">

                                                </div>
                                            </div>
                                        </div>
                                        <a class="carousel-control-prev" href="#demo" data-slide="prev">
                                            <span class="carousel-control-prev-icon"></span>
                                        </a>
                                        <a class="carousel-control-next" href="#demo" data-slide="next">
                                            <span class="carousel-control-next-icon"></span>
                                        </a>
                                    </div>
                                </div>

                                <!-- Modal footer -->
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-4 offset-1 offset-lg-2">
                    <!--TODO -->
                        <button class="btn btn-warning buttone">League</button>
                </div>
            </div>

            <!--PARTE SINISTRA DELLA TABELLA-->
            <div class="row">
                <div class="col-lg-1 col-5 "></div>
                <div class="mypcimage pt-4">
                    <img src="resources/img1/pcbuono.png" class="rounded img-fluid rounded float-right">
                </div>
            </div>

        </div>
    </div>

    <!--TABELLA-->
    <div class="col-lg-6 col-12 offset-lg-1 my-lg-3 " id="myGame"></div>

    <!--PARTE DESTRA DELLA TABELLA-->
    <div class="col-lg-3 col-12 offset-lg-0  ">
        <div class="row my-1">
            <div class="col-lg-3 col-6 offset-1 offset-lg-2 pl-lg-1 ">
                <button id='up' onclick='clickMove(event)' class="arrowButtonsAlone text-center">
                    <img src="resources/img1/arrowtrasparent1.png" class="rounded img-fluid rounded  rotate270"  > </img>
                </button>
            </div>
        </div>
        <div class="row">

            <div class="col-lg-3 col-4 offset-lg-0 offset-1 ml-lg-2">
                <button id = 'left' onclick='clickMove(event)' class="arrowButtons text-center">
                    <img src="resources/img1/arrowtrasparent1.png" class="rounded img-fluid rounded "  alt="Cinque Terre"  > </img>
                </button>

            </div>
            <div class="col-lg-3 col-4 offset-1 offset-lg-0">
                <button id='right' onclick='clickMove(event)' class="arrowButtons text-center">
                    <img src="resources/img1/arrowtrasparent1.png" class="rounded img-fluid rounded rotate180"  alt="Cinque Terre"  > </img>                    </div>
            </button>
        </div>

        <div class="row">

            <div class="col-lg-3 col-6 offset-1 offset-lg-2 pl-lg-1 ">
                <button id='down' onclick='clickMove(event)' class="arrowButtonsAlone text-center">
                    <img src="resources/img1/arrowtrasparent1.png" class="rounded img-fluid rounded  rotate90"  alt="Cinque Terre"  > </img>
                </button>
            </div>
        </div>

        <div class="row my-5">

            <div class="col-lg-5 col-6 offset-4 pt-2 mt-lg-3 offset-lg-1">

                <button id="gameButton" class="btn btn-warning buttone " onclick="startGame()">Start Game
                </button>
                <button id='resetButton' class="btn btn-warning buttone" onaction="/paritita">Reset Game</button>
            </div>
        </div>
    </div>
    <div class="row">

        <div class="col-lg-12 col-12 offset-lg-2 my-lg-0 watch" id="root">


            <script type="text/babel">
                function tick() {
                    const element = (<h3>{new Date().toLocaleTimeString()}</h3>);
                    ReactDOM.render(element, document.getElementById('root'));

                }

                setInterval(tick, 1000);
            </script>
        </div>
    </div>
</div>


<div class="row">
    <div class="col">
        <div class="alert alert-succes" id="messagerDiv" hidden></div>

    </div>
</div>
</body>
</html>
