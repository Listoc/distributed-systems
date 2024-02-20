const rateInput = document.getElementById('rate');
const amountInput = document.getElementById('amount');
const form = document.getElementById('form');

form.onsubmit = function () {
    if (isNaN(rateInput.value)) {
        alert("rate is not a number");
        return false;
    }

    if (!amountInput.value.match(/^[-+]?[0-9]+$/)) {
      alert("amount is not an integer")
      return false;
    }

    return true;
}