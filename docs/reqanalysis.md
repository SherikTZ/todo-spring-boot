# Requirements Analysis

## API

**METHOD**: GET\
**PATH**: /tasks\
**PURPOSE**: retrieves all tasks and returns them to the user.
**STATUS CODES**:

- OK (200) tasks retrieved

**RESPONSE FORMAT**:

```
[
    {
        "id": 1,
        "title": "Task1",
        "description": "Desk1"
    },
    {
        "id": 2,
        "title": "Task2",
        "description": "Desk2"
    }
]

```

**METHOD**: POST\
**PATH**: /tasks\
**PURPOSE**:\
Given task content create a new task with title, description and status and stores them in the database.\

**STATUS CODES**:

- OK (200) task created
- 400 (Bad Request)\
   title is missing\
   description is missing\
   title is above maximum length of 255 characters\
   text is above length of 65,535 characters

**RESPONSE FORMAT**:

```
{
    "id": 1,
    "title": "Task1",
    "description": "Desk1",
    "status": "pending"
}
```

**METHOD**: PUT\
**PATH:** /tasks/{id}\
**REQUEST:** id - id of a given task. \
**PAYLOAD**:

```
{
    "title": "Updated Task",
    "description": "Updated Description",
    "status": "completed"
}
```

**STATUS CODES**:

- OK (200) task deleted
- 400 (Bad Request)\
   ID is incorrect
  title is empty\
   description is empty\
   title is above maximum length of 255 characters\
   text is above length of 65,535 characters
- 404 (Not found)\
   ID is not found

**RESPONSE**:
N/A

**PURPOSE**:
Updates the specific task and puts it into database.

**METHOD**: DELETE
**PATH**: /tasks/{id}
**REQUEST:** id - id of a given task. \
**RESPONSE CODES**:

- 204 (No content/successful deletion)
- 400 (Bad Request)\
  ID is missing
- 404 (Not found)\
  ID is not found

**PURPOSE**:
Deletes the task with the specified id and removes it from database.

## SCHEMAS

### Task

| Field       | TYPE          | Flags  | Description             |
| ----------- | ------------- | ------ | ----------------------- |
| id          | BIGINT        | PK, AI | Primary id for the task |
| title       | VARCHAR (255) | NN     | Title of the task       |
| description | TEXT          |        | Description of the task |
