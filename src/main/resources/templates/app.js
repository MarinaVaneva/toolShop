let loadToolsBtn = document.getElementById("loadTools");

loadToolsBtn.addEventListener('click', reloadTools)

// TODO: create new tool

function reloadTools() {

    let toolsCntr = document.getElementById('tools-container')
    toolsCntr.innerHTML = ''

    fetch("http://localhost:8080/api/tools").
    then(response => response.json()).
    then(json => json.forEach(tool => {
        // create row
        let row = document.createElement('tr')

        let titleCol = document.createElement('td')
        let manufacturesCol = document.createElement('td')
        let priceCol = document.createElement('td')
        let actionCol = document.createElement('td')

        //tool
        titleCol.textContent = tool.title
        // manufacture
        manufacturesCol.textContent = tool.manufacturer
        priceCol.textContent = tool.price
        //actions
        //delete btn
        let deleteBtn = document.createElement('button')
        deleteBtn.innerText = 'DELETE'
        deleteBtn.dataset.id = tool.id
        deleteBtn.addEventListener('click', deleteBtnClicked)

        actionCol.appendChild(deleteBtn)

        row.appendChild(titleCol)
        row.appendChild(manufacturesCol)
        row.appendChild(priceCol)
        row.appendChild(actionCol)

        toolsCntr.appendChild(row)
    }))

}

function deleteBtnClicked(event) {
    let toolId = event.target.dataset.id;

    deleteTool(toolId)
}

function deleteTool(toolId) {

    var requestOptions = {
        method: 'DELETE'
    }

    fetch(`http://localhost:8080/api/tool/${toolId}`, requestOptions).
    then(_ => reloadTools()).
    catch(error => console.log('error', error))

}
