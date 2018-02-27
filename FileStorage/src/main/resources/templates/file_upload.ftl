<script src="/js/jquery.js"></script>
<script>
    function sendFile(file) {
        var formData = new FormData();
        formData.append("file", file);

        var xhr = new XMLHttpRequest();

        xhr.open("POST", "/files", true);
        xhr.send(formData,);
    }
</script>
<div>
    <input type="file" id="file" name="file" placeholder="Имя файла..."/>
    <button onclick="sendFile(($('#file'))[0]['file'][0])"
            class="btn btn-primary">Загрузить файл
    </button>
    <input type="hidden" id="file_hidden">
    <div class="filename"></div>
</div>