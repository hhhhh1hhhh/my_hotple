function myplaceSubmit(){
    var myplaceForm = document.myplaceForm;
    var placeName = myplaceForm.placeName.value;
    var address = myplaceForm.address.value;

    if(!placeName && !address) {
        alert("장소 이름과 주소를 입력해주세요");
        myplaceForm.onsubmit = function() {
            return false;
        };
    }
    else if(!placeName) {
        alert("장소 이름을 입력해주세요");
        myplaceForm.onsubmit = function() {
            return false;
        };
    }
    else if(!address) {
        alert("주소를 입력해주세요");
        myplaceForm.onsubmit = function() {
            return false;
        };
    }
    else {
        myplaceForm.submit();
        alert("저장되었습니다.");
    }
}