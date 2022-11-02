# Report - Assignment #04

> **Anastasiia Dunaeva** - up202202453
>
> **Lucas Silva** - up202103397
>
> **Francisco Pacheco** - up201906505

## Which use cases have you selected for testing and why.

### Case 1

This is one of the most important use cases. As a first scenario, the first use case regards the basic usage of the application. The main path leads to the creation of tasks following the common steps of a user. For example, the user can start configuring his task by adding a description or using its default value, and then can add it for a new creation (adding to the list of tasks) or set it as done directly or later. In the last case, the user can also delete his task (which will remove the task from the list of tasks).

### Case 2

The second use case concerns prioritization of tasks, which is important for the convenience of task management for the user, since tasks can then, for example, be ordered by priority. The user can prioritize tasks in the form of a letter from A to Z. The priority can be set as a task during the configuration process (before creation), or after its creation and appearance in the task list. The task may also have no priority, which is indicated by (-). The set priority can be removed.

### Case 3

...

## Derive the state machine, transition tree, and transition table of each use case.

> Note: write a brief description of each diagram.

### Case 1

<hr>

**State Machine**

![State Machine 1](../.github/%2304/SM/1_state_machine_main.png)

> The Main State Machine use case is divided by 5 states: _Configuring_ (before task are created), _Configured as Done_ (when checking the task configuring it as completed), _Created_ (when task is configured and added to the main list), _Done_ (state of task is done/completed and moved to the last position in the list), and, _Deleted_ (task is removed from the main list).

<br>

**Transition Table**

![Transition Table 1](../.github/%2304/Tables/transition_table1.png)

> The task can start from the state of _Configuring_ to the state of _Configured as Done_ and vice-versa (_Configuring -> Configured as Done_) by setting the task as _done_ before its _creation_ or after _creation_, the task can be checked as done (_Configuring -> Created -> Done_) and then the same task can be _deleted_, which will remove it from the list of tasks (_Configuring -> Configured as Done -> Done -> Deleted_) or (_Configuring -> Created -> Deleted_). After task is _done_ it can achieve states of _Created_ or _Deleted_ (_Configuring -> Configured as Done -> Done -> Created_) or (_Configuring -> Configured as Done -> Done -> Deleted_).

<br>

**Transition Tree**

![Transition Table 1](../.github/%2304/TT/1_transition_tree_main.png)

> The transition tree represented above is based on the possible states and transitions of state machine diagram for the main use case.

![Transition Tree Color 1](../.github/%2304/TT/tree_arrows1.png)

> There are 5 leaves in the tree, which means that there are 5 paths that cover all the states and transitions. The path is defined as the path from the root to the leaf. Each path represents a separate test case that will be implemented by QF-Test.

![State Machine Paths 1](../.github/%2304/SM/1_sm_main_paths.png)

> By displaying tree paths on the state diagram, we can see that each transition and state is covered at least once.

<br>

### Case 2

<hr>

**State Machine**

![State Machine 2](../.github/%2304/SM/2_state_machine_priority.png)

> In this use case there are 4 states: _Configuring_ (state of task before creation, when priority is not set), _Configured as Prioritized_ (state of task before creation, when priority is set), _Created_ (task is created, provided in task list and priority is not set), _Prioritized_ (task is created, provided in task list and priority is set).

<br>

**Transition Table**

![Transition Table 2](../.github/%2304/Tables/transition_table2.jpg)

> The task can go from the state _Configuring_ to the state _Configured as Prioritized_ and vice-versa by setting priority and deleting priority before task creation. After creating a task with an unspecified priority, a task with no priority appears (_Configuring_ -> _Created_). After creating a task with a set priority, a prioritized task appears (_Configured as Prioritized_ -> _Prioritized_). The task can go from the state _Created_ to the state _Prioritized_ and vice-versa by setting priority and deleting priority after task creation.

<br>

**Transition Tree**

![Transition Tree 2](../.github/%2304/TT/2_transition_tree_priority.png)

> The following tree is based on states and transitions of state machine diagram.

<br>

![Transition Tree Color 2](../.github/%2304/TT/tree_arrows2.png)

> There are 3 leaves in this tree, what means that there are 3 paths which covers all states and transitions. The path is defined as the path from the root to the leaf. Each path represents separated test case which will be implemented by QF-Test.

<br>

![State Machine Paths 2](../.github/%2304/SM/2_sm_priority_paths.png)

> By displaying tree paths on the state diagram, we can see that each transition and state is covered at least once.

<br>

### Case 3

<hr>

![Diagram Image 3](../.github/#04/diagram-image-3.png)

> Description 3...

<br>

## Brief description of each test developed on the QF-Test tool.

### Case 1

| Test Case | Description |
| --------- | ----------- |
| sample    | sample      |
| sample    | sample      |

### Case 2

| Test Case  | Description                                                                                                                                                                                                                                                                                                                                                                                            |
| ---------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| priority1  | Realize orange path in the tree (_Configuring_ -> _Configured as Prioritized_ -> _Configuring_).<br/> - Set priority (A) before creating task <br/> - Check that priority was set <br/> - Delete priority <br/> - Check that priority was deleted <br/> - Cleanup: close window                                                                                                                        |
| priority2  | Realize blue path in the tree (_Configuring_ -> _Configured as Prioritized_ -> _Prioritized_ -> _Created_). <br/> - Set priority (A) before creating task <br/> - Check that priority was set <br/> - Create task <br/> - Check that priority of created task is set to (A) <br/> - Delete priority of this task <br/> - Check that priority was deleted <br/> - Cleanup: delete task and close window |
| priority3  | Realize green path in the tree (_Configuring_ -> _Created_ -> _Prioritized_). <br/> - Create new task with unspecified priority <br/> - Check that task is created with unspecified priority <br/> - Set priority (A) for created task <br/> - Check that priority was set to (A) <br/> - Cleanup: delete task and close window                                                                        |
| sneak-path | Sneak path: delete priority while _Configuring_ and state is not changed. <br/> - Delete priority of configuring task <br/> - Check that task doesn't have priority set <br/> - Cleanup: close window                                                                                                                                                                                                  |

![QF-Test Priority](../.github/%2304/QF-Screenshots/2_priority.png)

### Case 3

| Test Case | Description |
| --------- | ----------- |
| sample    | sample      |
| sample    | sample      |

## Brief description of the outcome of each test and whether any test results in a failure (and why).

### Case 1

| Test Case | Outcome | Failure Reason |
| --------- | ------- | -------------- |
| sample    | sample  | -              |
| sample    | sample  | sample         |

### Case 2

| Test Case  | Outcome                                                                           | Failure Reason                      |
| ---------- | --------------------------------------------------------------------------------- | ----------------------------------- |
| priority1  | Asserts were successful                                                           | -                                   |
| priority2  | Asserts were successful                                                           | -                                   |
| priority3  | Firstly assert was failed. <br/> After errors correction asserts were successful. | Tasks was not deleted while cleanup |
| sneak-path | Asserts were successful                                                           | -                                   |

### Case 3

| Test Case | Outcome | Failure Reason |
| --------- | ------- | -------------- |
| sample    | sample  | -              |
| sample    | sample  | sample         |

## In English (mandatory), detail feedback/opinion of the QF-Test tool.

...
