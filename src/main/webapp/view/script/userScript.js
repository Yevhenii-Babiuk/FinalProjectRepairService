var selectedRow = null;
function onFormSubmit() {
    var formData = readFormData();
    updateRecord(formData);
    submitForm(formData);
    resetForm();
}

function readFormData() {
    var formData = {};
    formData["name"] = document.getElementById("name").value.trim();
    formData["surname"] = document.getElementById("surname").value.trim();
    formData["phone"] = document.getElementById("phone").value.trim();
    formData["address"] = document.getElementById("address").value.trim();
    formData["login"] = document.getElementById("login").value.trim();
    formData["role"] = document.getElementById("role").value.trim();
    return formData;
}

function resetForm() {
    document.getElementById("name").value="";
    document.getElementById("surname").value="";
    document.getElementById("phone").value="";
    document.getElementById("address").value="";
    document.getElementById("login").value="";
    document.getElementById("role").value="";
}

function onEdit(td) {
    selectedRow = td.parentElement.parentElement;
    document.getElementById("name").value=selectedRow.cells[1].innerHTML;
    document.getElementById("surname").value=selectedRow.cells[2].innerHTML;
    document.getElementById("phone").value=selectedRow.cells[5].innerHTML;
    document.getElementById("address").value=selectedRow.cells[4].innerHTML;
    document.getElementById("login").value=selectedRow.cells[3].innerHTML;
    document.getElementById("role").value=selectedRow.cells[6].innerHTML;
}

function updateRecord(formData) {
    selectedRow.cells[1].innerHTML=formData.name;
    selectedRow.cells[2].innerHTML=formData.surname;
    selectedRow.cells[5].innerHTML=formData.phone;
    selectedRow.cells[4].innerHTML=formData.address;
    selectedRow.cells[3].innerHTML=formData.login;
    selectedRow.cells[6].innerHTML=formData.role;
}

function submitForm(formData) {
    var jsonObject = JSON.stringify(formData);

    var xhr = new XMLHttpRequest();
    xhr.open('POST', "/account/edit", true);
    xhr.setRequestHeader("Content-Type", 'application/x-www-form-urlencoded');
    xhr.send(jsonObject);
    xhr.onload = function () {
    }
}

