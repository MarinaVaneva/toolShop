const backendLocation = 'http://localhost:8080'
let toolId = document.getElementById("toolId").getAttribute("value")
let toolSection = document.getElementById("toolCtnr")
function reloadTools() {

    fetch(`${backendLocation}/api/${toolId}/tools`).
    then(response => response.json()).
        then((body)=> {
        addToolAsHtml(tool)
    }
)
    // then(json => json.forEach(tool => {
    //     // create row
    //     let row = document.createElement('tr')
    //
    //     let titleCol = document.createElement('td')
    //     let manufacturesCol = document.createElement('td')
    //     let priceCol = document.createElement('td')
    //     // let actionCol = document.createElement('td')
    //
    //     //tool
    //     titleCol.textContent = tool.title
    //     // manufacture
    //     manufacturesCol.textContent = tool.manufacturer
    //     priceCol.textContent = tool.price
    //

    //
    // }))

}
