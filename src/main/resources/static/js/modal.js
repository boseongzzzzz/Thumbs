// 모달을 표시하는 함수
function showModal() {
  var modal = document.getElementById("person-search-modal");
  modal.style.display = "block";
}

// 모달을 닫는 함수
function hideModal() {
  var modal = document.getElementById("person-search-modal");
  modal.style.display = "none";
}

// 선택된 데이터를 출력하고 추가하는 함수
function addSelectedData() {
  event.preventDefault();
  deleteSelecteDate();
  var selectedPeople = document.querySelectorAll(
    'input[name="person"]:checked'
  );
  var selectedPeopleList = document
    .getElementById("selected-people")
    .getElementsByTagName("ul")[0];

  for (var i = 0; i < selectedPeople.length; i++) {
    var person = selectedPeople[i].value;
    var li = document.createElement("li");
    li.textContent = person;
    selectedPeopleList.appendChild(li);
  }
  hideModal();
}

function deleteSelecteDate() {
  var ul = document.querySelector("#selected-people ul");
  while (ul.firstChild) {
    ul.removeChild(ul.firstChild);
  }
}
