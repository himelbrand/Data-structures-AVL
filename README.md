# Data-structures-AVL
data structures practical assignment

## this is my solution to this practical data structures assignment

# Instructions summary and translation (hebrew instruction in pdf)

### Assignment topics
** design efficiante data sturcture for the algorithm
** analasys of different run-times in different parts of the algorithm
** implementation of the data sturcture in Java

## back-story
based on the Diffie-Hellman method for creating a shared secret between two participants among a listener.
more info : https://en.wikipedia.org/wiki/Diffie%E2%80%93Hellman_key_exchange

this assignment we will focus on the method presented by Ralph Merkel, the idea in this version of his idea is based on creating random "riddles" by one side, the second side chooses a riddle randomly, solves it, each riddle encrypts a serial number of the riddle and a secret encryption key, then sends back only the serial number, now they can communicate until the third party, the listener, has extracted the secret encryption key.
for this assignment the parties will be: Alice and Bob are sides 1 and 2, while Eve will be the listener (implemented as Java classes).
so Alice and Bob has the advantage that Alice created the riddles and therefore can easily find the secert key after receiving the riddle's serial number.

### more info to be added


