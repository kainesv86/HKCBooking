<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${param.title}</title>
<script src="https://cdn.tailwindcss.com"></script>
<style>

    @keyframes FadeIn {
        0% {
            opacity: 0;
        }
        100% {
            opacity: 1;
        }
    }

    .fade-in {
        animation: FadeIn 0.5s;
    }

    @keyframes ZoomIn {
        0% { opacity: 0;
             transform: scale(0) translate(100%, 100%);
        }
        100% { opacity: 1;
               transform: scale(1) translate(0, 0);
        }
    }

    .zoom-in {
        animation: ZoomIn 1s;
    }

    .fade-in-index {
        animation: FadeIn 1s 1s forwards;
    }


</style>