document.addEventListener("DOMContentLoaded", () => {
  const select = document.getElementById("memberSelect");
  const panel = document.getElementById("memberInfo");

  if (!select || !panel) return;

  const elNombre = document.getElementById("nombre");
  const elCargo = document.getElementById("cargo");
  const elCorreo = document.getElementById("correo");
  const elBadge = document.getElementById("badgeInitials");

  const initials = (text) => {
    if (!text) return "WF";
    const parts = text.trim().split(/\s+/).slice(0, 2);
    return parts.map(p => p[0].toUpperCase()).join("");
  };

  select.addEventListener("change", () => {
    const codigo = select.value;

    if (!codigo) {
      panel.style.display = "none";
      return;
    }

    const integrante = (window.membersData || []).find(x => String(x.codigo) === String(codigo));
    if (!integrante) {
      panel.style.display = "none";
      return;
    }

    elNombre.textContent = integrante.nombreVisible;
    elCargo.textContent = integrante.cargo;

    const correo = integrante.correoContacto;
    elCorreo.textContent = correo;
    elCorreo.href = `mailto:${correo}`;

    elBadge.textContent = initials(integrante.nombreVisible);

    panel.style.display = "flex";
  });
});
