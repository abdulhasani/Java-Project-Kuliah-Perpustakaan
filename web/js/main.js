$(document).ready(function() {
    $('ul.sf-menu').superfish({
      delay: 250,
      animation: {opacity:'show',height:'show'},
      speed: 'fast',
      autoArrows: false
   });
});

$(window).load(function() {
    $('#slider').nivoSlider({
        effect:'boxRain',
        slices:10,
        boxCols: 10,
        boxRows: 6,
        animSpeed:500,
        pauseTime:5000,
        controlNav:false
    });
});