$(document).ready(function(){
new WOW().init();

var typed=new Typed(`#type`,{
     strings:[" WILDLIFE-TRACKER "," It's an application that allows Wildlife-rangers to track wildlife sightings in the area. "],
     backSpeed:70,
     typeSpeed:80,
     smartBackspace:true,
     loop: true,
   })
   var typed =new Typed(`#msg`,{
        strings:[" Your Animal has been saved ! "],
        backSpeed:80,
        typeSpeed:90,
        smartBackspace:true,
      })
})


function secondClick(){
timer:4000
Swal.fire(
  'View Animals?',
)
}

function firstClick(){
timer:4000
Swal.fire(
  'Add endangered?',

)
}
function thirdClick(){
timer:4000
Swal.fire(
  'Add Sighting?',
)
}
new WOW().init();