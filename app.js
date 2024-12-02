// Get elements
const taskInput = document.getElementById('task-input');
const addButton = document.getElementById('add-btn');
const sortButton = document.getElementById('sort-btn');
const taskList = document.getElementById('task-list');

// Event listener for the 'Add Task' button
addButton.addEventListener('click', addTask);

// Event listener for the 'Sort Tasks' button
sortButton.addEventListener('click', sortTasks);

function addTask() {
    const taskText = taskInput.value.trim();
    
    if (taskText === '') {
        alert('Please enter a task.');
        return;
    }

    // Create new list item for the task
    const taskItem = document.createElement('li');
    taskItem.textContent = taskText;
    
    // Create a remove button for the task
    const removeButton = document.createElement('button');
    removeButton.textContent = 'Remove';
    removeButton.classList.add('remove-btn');
    taskItem.appendChild(removeButton);
    
    // Add the task to the task list
    taskList.appendChild(taskItem);
    
    // Clear the input field
    taskInput.value = '';
    
    // Add event listener to remove button
    removeButton.addEventListener('click', () => taskList.removeChild(taskItem));
}

function sortTasks() {
    const tasks = Array.from(taskList.children);
    tasks.sort((a, b) => a.textContent.localeCompare(b.textContent));
    taskList.innerHTML = '';
    tasks.forEach(task => taskList.appendChild(task));
}
