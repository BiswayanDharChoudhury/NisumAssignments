function navigate(pageId){
    const pages = document.querySelectorAll('.page');
    pages.forEach(page =>{
        page.classList.remove('active');
    });

    const activePage = document.getElementById(pageId);
    if(activePage){
        activePage.classList.add('active');
    }
}

window.addEventListener('load',() =>{
    const hash = window.location.hash.substring(1);
    if(hash){
        navigate(hash);
    }
});
