document.addEventListener("DOMContentLoaded", () => {
  // Pequeñas mejoras UX para el formulario
  const phoneInput = document.querySelector('input[type="tel"]');
  if (phoneInput) {
    phoneInput.addEventListener("input", () => {
      // Deja solo números y espacios (sin ser agresivo)
      phoneInput.value = phoneInput.value.replace(/[^0-9\s+()-]/g, "");
    });
  }

  const form = document.querySelector("form.form");
  if (!form) return;

  form.addEventListener("submit", (e) => {
    const required = form.querySelectorAll("[required]");
    for (const field of required) {
      if (!field.value || !String(field.value).trim()) {
        e.preventDefault();
        field.focus();
        field.classList.add("is-error");
        setTimeout(() => field.classList.remove("is-error"), 900);
        return;
      }
    }
  });
});
