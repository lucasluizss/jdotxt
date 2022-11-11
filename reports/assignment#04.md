# Report - Assignment #04

> **Anastasiia Dunaeva** - up202202453
>
> **Lucas Silva** - up202103397
>
> **Francisco Pacheco** - up201906505

## Which use cases have you selected for testing and why.

<hr>

### Case 1

This is one of the most important use cases. As a first scenario, the first use case regards the basic usage of the application. The main path leads to the creation of tasks following the common steps of a user. For example, the user can start configuring his task by adding a description or using its default value, and then can add it for a new creation (adding to the list of tasks) or set it as done directly or later. Also, the user can also delete his task (which will remove the task from the list of tasks).

### Case 2

The second use case concerns prioritization of tasks, which is important for the convenience of task management for the user, since tasks can then, for example, be ordered by priority. The user can prioritize tasks in the form of a letter from A to Z. The priority can be set as a task during the configuration process (before creation), or after its creation and appearance in the task list. The task may also have no priority, which is indicated by (-). The set priority can be removed.

### Case 3

The third use cases focus on a specific feature of the Jdotxt App. This feature gives to the user the possibility to hide tasks, this could be used to make the interface cleaner or to any other goal that user finds this feature relevant. Also, this feature is very easy to use. The user just has to add "h:1" in front of the task's title. After this, the user can hide or show the tasks with this property by simply click on the "H" button on the top of the interface.

<br>

## Derive the state machine, transition tree, and transition table of each use case.

<hr>
<br>

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

**State Machine**

![State Machine 3](../.github/%2304/SM/3_state_machine_hidden.png)

> In this use case there are 4 states: _Configuring_ (state of task before creation, when hidden tag is not set), _Configured as Hidden_ (state of task before creation, when hidden tag is set), _Displayed_ (task is created with the hidden tag and H button is enabled, so the task is present on the tasks list), _Hidden_ (task is created with the hidden tag but H button is disable, so the task isn't present on the tasks list).

<br>

**Transition Table**

![Transition Table 3](../.github/%2304/Tables/transition_table3.png)

> The task can go from the state _Configuring_ to the state _Configured as Hidden_ and vice-versa by setting the hidden tag on task's title or by removing it. After the task is _Configured as Hidden_ when is created it can go to the states _Displayed_ (if H button is enabled) or _Hidden_ (if H button is disabled). After this, when the task is created it can go from _Displayed_ to _Hidden_ and vice-versa by simply disable/enable the H button.

<br>

**Transition Tree**

![Transition Tree 3](../.github/%2304/TT/3_transition_tree_hidden.png)

> The following tree represent the possible transitions present on the state machine diagram of the 3-use-case

<br>

![Transition Tree Color 3](../.github/%2304/TT/tree_arrows3.png)

> There are 3 leaves in this tree, what means that there are 3 paths which covers all states and transitions. The path is defined as the path from the root to the leaf. Each path represents separated test case which will be implemented by QF-Test.

<br>

![State Machine Paths 3](../.github/%2304/SM/3_sm_priority_paths.png)

> By displaying tree paths on the state diagram, we can see that each transition and state is covered at least once.

<br>

## Brief description of each test developed on the QF-Test tool.

<hr>

### Case 1

<table>
	<thead>
		<tr>
			<th>Test Case</th>
			<th>Description</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>main1</td>
			<td>
				Realize orange path in the tree (<i>Configuring</i> -> <i>Configured as Done</i> -> <i>Configuring</i>). <br>
				- Set task as done (checkbox) before adding it <br>
				- Check if task was set as done <br>
				- Set configuring task as not done <br>
				- Check if task is not mark as done <br>
				- Cleanup: reset task
			</td>
		</tr>
		<tr>
			<td>main2</td>
			<td>
				Realize blue path in the tree (<i>Configuring</i> -> <i>Configured as Done</i> -> <i>Done</i> -> <i>Created</i>). <br>
				- Set task done <br>
				- Check task is set as done <br>
				- Create task <br>
				- Check task was created <br>
				- Check created task is configured as done <br>
				- Cleanup: delete task
			</td>
		</tr>
		<tr>
			<td>main3</td>
			<td>
				Realize green path in the tree (<i>Configuring</i> -> <i>Configured as Done</i> -> <i>Done</i> -> <i>Deleted</i>). <br>
				- Set task done <br>
				- Check task is set as done <br>
				- Create task <br>
				- Check task was created <br>
				- Check created task is configured as done <br>
				- Delete task <br>
				- Cleanup: check deleted task
			</td>
		</tr>
		<tr>
			<td>main4</td>
			<td>
				Realize red path in the tree (<i>Configuring</i> -> <i>Created</i> -> <i>Done</i>)  <br>
				- Create task <br>
				- Check task was created <br>
				- Set created task as done <br>
				- Check created task is configured as done <br>
				- Cleanup: delete task
			</td>
		</tr>
		<tr>
			<td>main5</td>
			<td>
				Realize yellow path in the tree (<i>Configuring</i> -> <i>Created</i> -> <i>Deleted</i>)  <br>
				- Create task <br>
				- Check task was created <br>
				- Delete task <br>
				- Cleanup: check deleted task
			</td>
		</tr>
		<tr>
			<td>sneak-path</td>
			<td>
				- Create task <br>
				- Check task was created <br>
				- Delete task <br>
				- Cleanup: check deleted task
			</td>
		</tr>
	</tbody>
</table>

![QF-Test Priority](../.github/%2304/QF-Screenshots/1_main.png)

<br>

### Case 2

<table>
	<thead>
		<tr>
			<th>Test Case</th>
			<th>Description</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>priority1</td>
			<td>
			Realize orange path in the tree (<i>Configuring<i> -> <i>Configured as Prioritized</i> -> <i>Configuring</i>).<br/>
			- Set priority (A) before creating task <br/>
			- Check that priority was set <br/>
			- Delete priority <br/>
			- Check that priority was deleted <br/>
			- Cleanup: close window
			</td>
		</tr>
		<tr>
			<td>priority2</td>
			<td>
			Realize blue path in the tree (<i>Configuring</i> -> <i>Configured as Prioritized</i> -> <i>Prioritized</i> -> <i>Created</i>). <br/>
			- Set priority (A) before creating task <br/>
			- Check that priority was set <br/>
			- Create task <br/>
			- Check that priority of created task is set to (A) <br/>
			- Delete priority of this task <br/>
			- Check that priority was deleted <br/>
			- Cleanup: delete task and close window
			</td>
		</tr>
		<tr>
			<td>priority3</td>
			<td>
			Realize green path in the tree (<i>Configuring</i> -> <i>Created</i> -> <i>Prioritized</i>). <br/>
			- Create new task with unspecified priority <br/>
			- Check that task is created with unspecified priority <br/>
			- Set priority (A) for created task <br/>
			- Check that priority was set to (A) <br/>
			- Cleanup: delete task and close window
			</td>
		</tr>
		<tr>
			<td>sneak-path</td>
			<td>
			Sneak path: delete priority while <i>Configuring</i> and state is not changed. <br/>
			- Delete priority of configuring task <br/>
			- Check that task doesn't have priority set <br/>
			- Cleanup: close window
			</td>
		</tr>
	</tbody>
</table>

![QF-Test Priority](../.github/%2304/QF-Screenshots/2_priority.png)

<br>

### Case 3

<table>
	<thead>
		<tr>
			<th>Test Case</th>
			<th>Description</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>hidden1</td>
			<td>
			Realize red path in the tree (<i>Configuring<i> -> <i>Configured as Hidden</i> -> <i>Configuring</i>).<br/>
			- Set tittle with hidden tag (h:1) <br/>
			- Check that hidden tag was set <br/>
			- Delete hidden tag <br/>
			- Check that hidden tag was deleted <br/>
			- Cleanup: reset task
			</td>
		</tr>
		<tr>
			<td>hidden2</td>
			<td>
			Realize green path in the tree (<i>Configuring</i> -> <i>Configured as Hidden</i> -> <i>Hidden</i> -> <i>Displayed</i>). <br/>
			- Disable H button <br/>
			- Set tittle with hidden tag (h:1) <br/>
			- Check that hidden tag was set <br/>
			- Create task <br/>
			- Check that task dont appear on the tasks list <br/>
			- Enable H button <br/>
			- Check that task appear on the tasks list <br/>
			- Cleanup: delete task
			</td>
		</tr>
		<tr>
			<td>hidden3</td>
			<td>
			Realize blue path in the tree (<i>Configuring</i> -> <i>Configured as Hidden</i> -> <i>Displayed</i> -> <i>Hidden</i>). <br/>
			- Set tittle with hidden tag (h:1) <br/>
			- Check that hidden tag was set <br/>
			- Create task <br/>
			- Check that task appear on the tasks list <br/>
			- Disable H button <br/>
			- Check that task dont appear on the tasks list <br/>
			- Cleanup: enable H button, delete task
			</td>
		</tr>
		<tr>
			<td>sneak-path</td>
			<td>
			Sneak path: enable/disable "H" button while <i>Configuring</i> and keep on the same state. <br/>
			- Enable "H" button <br/>
			- Disable "H" button <br/>
			- Check that no new task appeared <br/>
			- Cleanup: reset task
			</td>
		</tr>
	</tbody>
</table>

![QF-Test Priority](../.github/%2304/QF-Screenshots/3_case.png)

<br>

## Brief description of the outcome of each test and whether any test results in a failure (and why).

<hr>

### Case 1

| Test Case  | Outcome                                   | Failure Reason                                           |
| ---------- | ----------------------------------------- | -------------------------------------------------------- |
| main1      | Firstly assert failed and fixed after on. | Configuring input was not mathing with the expected text |
| main2      | Asserts were successful                   | -                                                        |
| main3      | Asserts were successful                   | -                                                        |
| main4      | Asserts were successful                   | -                                                        |
| main5      | Asserts were successful                   | -                                                        |
| sneak-path | Asserts were successful                   | -                                                        |

### Case 2

| Test Case  | Outcome                                                                           | Failure Reason                      |
| ---------- | --------------------------------------------------------------------------------- | ----------------------------------- |
| priority1  | Asserts were successful                                                           | -                                   |
| priority2  | Asserts were successful                                                           | -                                   |
| priority3  | Firstly assert was failed. <br/> After errors correction asserts were successful. | Tasks was not deleted while cleanup |
| sneak-path | Asserts were successful                                                           | -                                   |

### Case 3

| Test Case  | Outcome                                   | Failure Reason                                                                                            |
| ---------- | ----------------------------------------- | --------------------------------------------------------------------------------------------------------- |
| hidden1    | Asserts were successful                   | -                                                                                                         |
| hidden2    | Firstly assert failed and fixed after on. | When change the state of the H button the title resets and also the check verifier was in the wrong panel |
| hidden3    | Asserts were successful                   | -                                                                                                         |
| sneak-path | Asserts were successful                   | -                                                                                                         |

## Feedback of the QF-Test tool.

While developing the first use case it was possible to note how can we use this tool for development growth. It's possible to prevent multiple ways of failure, doing changes in different ways and validating it according to the business specification. It is not so easy for understanding the usage of the tool at first, but with some tries and errors, it is notable the power it brings for scaling new applications and assure quality.
