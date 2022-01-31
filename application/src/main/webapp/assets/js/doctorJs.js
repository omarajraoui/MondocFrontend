let count;
function starmark(item)
{
count=item.id[0];
sessionStorage.starRating = count;
let subid= item.id.substring(1);
for(let i=0;i<5;i++)
{

	document.getElementById("rating").value=count;
	
if(i<count)
{
document.getElementById((i+1)+subid).style.color="orange";
}
else
{
document.getElementById((i+1)+subid).style.color="black";
}


}

}

/*for(let i = 1 ; i<13 ;i++){
  let a = ratingButton*i;
  document.getElementById("a").onclick =  () => {

    location.href = "rate.html";
  
  };

}*/

// document.getElementById("nomDoc").value
// document.getElementById("specialiteDoc").value



function result()
{
	
	
//Rating : Count
//Review : Comment(id)
alert("Rating : "+count+"\nReview : "+document.getElementById("comment").value);
}


