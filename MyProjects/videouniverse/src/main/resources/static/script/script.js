let bigButton = document.getElementById("big-button");

bigButton.addEventListener("click", function (e) {
    var x = document.getElementById("small-buttons");
    console.log(x.style)
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
});