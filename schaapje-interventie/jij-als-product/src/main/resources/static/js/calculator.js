// Live slider label updates
function syncVal(input, outputId, suffix, prefix) {
    const out = document.getElementById(outputId);
    if (!out) return;
    if (prefix) {
        out.textContent = suffix + input.value;
    } else {
        out.textContent = input.value + suffix;
    }
}

// Animate metric values when results appear
document.addEventListener('DOMContentLoaded', function () {
    const metrics = document.querySelectorAll('.metric-value');
    metrics.forEach(function (el) {
        el.style.opacity = '0';
        el.style.transform = 'translateY(8px)';
        el.style.transition = 'opacity 0.4s ease, transform 0.4s ease';
        setTimeout(function () {
            el.style.opacity = '1';
            el.style.transform = 'translateY(0)';
        }, 100);
    });

    // Scroll to results on page load if they exist
    const results = document.querySelector('.results-section');
    if (results) {
        setTimeout(function () {
            results.scrollIntoView({ behavior: 'smooth', block: 'start' });
        }, 200);
    }
});

// Ervaringsblok
var selectedFeeling = null;
var selectedIntent = null;

function selectFeeling(btn, value) {
    document.querySelectorAll('.feeling-btn').forEach(function(b) { b.classList.remove('selected'); });
    btn.classList.add('selected');
    selectedFeeling = value;
}

function goStep2() {
    if (!selectedFeeling) {
        alert('Kies eerst hoe je je voelt.');
        return;
    }
    document.getElementById('step-1').style.display = 'none';
    document.getElementById('step-2').style.display = 'block';
}

function selectIntent(btn, value) {
    document.querySelectorAll('.yesno-btn').forEach(function(b) { b.classList.remove('selected'); });
    btn.classList.add('selected');
    selectedIntent = value;
}

function submitExperience() {
    if (!selectedIntent) {
        alert('Kies een van de opties.');
        return;
    }
    document.getElementById('step-2').style.display = 'none';
    var msgs = {
        'yes': 'Goed bezig. Kleine stappen tellen al. Bekijk de tips-pagina voor concrete eerste acties.',
        'maybe': 'Twijfelen is een begin.',
        'no': 'Eerlijk antwoord. Bewust zijn van wat er speelt is al waardevol.'
    };
    document.getElementById('thankyou-msg').textContent = msgs[selectedIntent];
    document.getElementById('exp-thankyou').style.display = 'block';
}

function toggleNav() {
    var links = document.getElementById('nav-links');
    links.classList.toggle('open');
}


document.addEventListener('DOMContentLoaded', function () {
    document.querySelectorAll('.nav-links a').forEach(function (a) {
        a.addEventListener('click', function () {
            document.getElementById('nav-links').classList.remove('open');
        });
    });
});
