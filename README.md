# Schedular

Schedular is the final project of operating systems course at Ferdowsi University of Mashhad.

### Overview

When a task is assigned to the highest-priority queue but lacks the necessary resources for execution, it is removed from the ready queue and placed in the waiting queue.

The waiting queue contains tasks that are capable of execution but are currently unable to proceed due to resource unavailability. To prevent resource starvation within the waiting queue, it is essential to arrange the queue in a manner that maximizes resource utilization based on the available resources within the system. Aging is employed as a strategy to ensure that tasks with extended wait times progressively gain priority.

In this approach, tasks in the waiting queue with lower priorities are periodically boosted in priority after a set time quantum has passed. Consequently, over time, tasks with initially lower priorities can transition into higher-priority tasks and become eligible for execution in the ready queue.

The scheduling strategy can be designed such that, when selecting a task to promote from the waiting queue to the ready queue, the task with the lowest priority among the waiting tasks is chosen. This selection is necessary because a task in the ready queue might have a lower priority than the currently running task. As a result, the lower-priority task in the ready queue cannot preempt the running task and cause an interruption, ensuring that the CPU remains dedicated to the ongoing task