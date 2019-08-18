var selectedRow = null;
function onFormSubmit() {
    elem.disabled=false
    var formData = readFormData();
    updateRecord(formData);
    submitForm(formData);
    resetForm();
}

function readFormData() {
    var formData = {};
    formData["orderId"] = document.getElementById("orderId").value.trim();
    formData["masterSurname"] = document.getElementById("masterSurname").value.trim();
    formData["managerSurname"] = document.getElementById("managerSurname").value.trim();
    formData["solving"] = document.getElementById("solving").value.trim();
    formData["status"] = document.getElementById("status").value;
    formData["endDate"] = document.getElementById("endDate").value;
    return formData;
}

function resetForm() {
    document.getElementById("orderId").value="";
    document.getElementById("masterSurname").value="";
    document.getElementById("managerSurname").value="";
    document.getElementById("solving").value="";
    document.getElementById("status").value="";
    document.getElementById("endDate").value="";
}

function onEdit(td) {
    selectedRow = td.parentElement.parentElement;
    document.getElementById("orderId").value=selectedRow.cells[0].innerHTML;
    document.getElementById("masterSurname").value=selectedRow.cells[3].innerHTML;
    document.getElementById("managerSurname").value=selectedRow.cells[4].innerHTML;
    document.getElementById("solving").value=selectedRow.cells[7].innerHTML;
    document.getElementById("status").value=selectedRow.cells[10].innerHTML;
    document.getElementById("endDate").value=selectedRow.cells[11].innerHTML;
}

function updateRecord(formData) {
    selectedRow.cells[0].innerHTML=formData.orderId;
    selectedRow.cells[3].innerHTML=formData.masterSurname;
    selectedRow.cells[4].innerHTML=formData.managerSurname;
    selectedRow.cells[7].innerHTML=formData.solving;
    selectedRow.cells[10].innerHTML=formData.status;
    selectedRow.cells[11].innerHTML=formData.endDate;
}

function submitForm(formData) {
    var jsonObject = JSON.stringify(formData);

    var xhr = new XMLHttpRequest();
    xhr.open('POST', "/editOrder", true);
    xhr.setRequestHeader("Content-Type", 'application/x-www-form-urlencoded');
    xhr.send(jsonObject);
    xhr.onload = function () {
    }
}

