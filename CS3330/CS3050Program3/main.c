/****************************
 * Caleb Sellinger
 * CS3050
 * Programming Assignment #3
 * 7 May 2020
****************************/

#include <stdio.h>
#include <stdlib.h>

//Vertex nodes
typedef struct node{
    int floorNum;
    int color;  //0 for white, 1 for grey, and 2 for black
    struct node *right;
    struct node *left;
} Vertex;

//Doubly Linked List for graph structure
//to represent up and down nature of building
typedef struct graph{
    Vertex *head;
} Graph;

//Queue for BFS
typedef struct qNode{
    Vertex *v;
    struct qNode *next;
}qNode;

typedef struct queue{
    qNode *head;
    qNode *tail;
} Queue;

//Function Prototypes
Graph *initGraph(Graph *);
Queue *initQueue(Queue *);
Vertex *createVertex(int);
Graph *insertGraph(Graph *, Vertex *);
Vertex *Dequeue(Queue **);
int Enqueue(Queue **, Vertex *);

int main(int argc, char** argv) {
    int floors = -1;
    int start = -1;
    int goal = -1;
    int up = -1;
    int down = -1;
    Queue *q = initQueue(q);
    
    //input
    while (floors > 100 || floors < 0){
        printf("Floors: ");
        scanf("%d", &floors);
    }
    
    while (start < 1 || start > 100){
        printf("Start: ");
        scanf("%d", &start);
    }
    
    while (goal > 100 || goal < 0){
        printf("Goal: ");
        scanf("%d", &goal);
    }
    
    while (up > 100 || up < 0){
        printf("Up: ");
        scanf("%d", &up);
    }
    
    while (down > 100 || down < 0){
        printf("Down: ");
        scanf("%d", &down);
    }
    
    //initialize graph
    Graph *graph = initGraph(graph);
    for (int i = 1; i <= floors; i++){
        Vertex *newVertex = createVertex(i);
        graph = insertGraph(graph, newVertex);
    }
    
    //adjacency matrix
    int adj[floors][floors];
    Graph *makeConnection = graph;
    for (int i = 0; i < floors; i++){
        for (int j = 0; j < floors; j++){
            adj[i][j] = 0;
        }
    }
    
    while (makeConnection->head->left != NULL){
        adj[makeConnection->head->floorNum - 1][makeConnection->head->left->floorNum - 1] = 1;
        adj[makeConnection->head->left->floorNum - 1][makeConnection->head->floorNum - 1] = 1;
        makeConnection->head = makeConnection->head->left;
    }
    
    //prints matrix
    for (int i = 0; i < floors; i++){
        for (int j = 0; j < floors; j++){
            printf("%d ", adj[i][j]);
            if (j == floors - 1){
                printf("\n");
            }
        }
    }
    printf("\n\n");
    
    /*BFS and output below*/
    
    //Find start vertex and put it into the queue
    Vertex *source;
    Vertex *traverse = graph->head; //starts at bottom floor
    while (traverse->floorNum != start && traverse != NULL){
        traverse = traverse->right;
    }
    source = traverse;
    Enqueue(&q, source);
    
    //search
    Queue *shortestPath = initQueue(shortestPath);
    Vertex *curr = NULL;
    Vertex *temp = NULL;
    while (q != NULL){
        curr = Dequeue(&q);
        temp = curr;
        
        if (curr->color == 0){
            curr->color = 1;
        }
        
        if ((temp->left == NULL || temp->left->color == 1) && (temp->right == NULL || temp->right->color == 1)){
            temp->color = 2;    //black
        }
        
        printf("%d->", temp->floorNum);
        //step right of temp (up)
        for (int i = 0; i < up; i++){
            if (temp->right == NULL){
                break;
            }
            temp = temp->right;
        }
        if (temp->color == 0){  //white
            temp->color = 1;    //grey
            Enqueue(&q, temp);
        }
        //step left of temp (down)
        temp = curr;
        for (int i = 0; i < down; i++){
            if (temp->left == NULL){
                break;
            }
            temp = temp->left;
        }
        if (temp->color == 0){  //white
            temp->color = 1;    //grey
            Enqueue(&q, temp);
        }
        
        if (curr->floorNum == goal){
            return 0;
        }
    }
    printf("Use the stairs!");

    return 0;
}

Queue *initQueue(Queue *q){
    q = malloc(sizeof(Queue));
    q->head = q->tail = NULL;
    return q;
}

int Enqueue(Queue **q, Vertex *v){
    qNode *newNode = malloc(sizeof(qNode));
    newNode->v = v;
    newNode->next = NULL;
    
    if (*q == NULL){
        *q = initQueue(*q);
    }
    
    if ((*q)->head == NULL){
        (*q)->head = (*q)->tail = newNode;
        return 0;
    }
    
    newNode->next = (*q)->tail;
    (*q)->tail = newNode;
    
    return 0;
}

Vertex *Dequeue(Queue **q){
    Vertex *delete = (*q)->head->v;
    
    if ((*q)->head == (*q)->tail){
        *q = NULL;
        return delete;
    }
    
    qNode *temp = (*q)->tail;
    while (temp->next != (*q)->head){
        temp = temp->next;
    }
    (*q)->head = temp;
    
    return delete;
}

Graph *initGraph(Graph *g){
    g = malloc(sizeof(Graph));
    g->head = NULL;
}

Vertex *createVertex(int floorNum){
    Vertex *newVertex = malloc(sizeof(Vertex));
    
    newVertex->floorNum = floorNum;
    newVertex->color = 0;
    newVertex->left = newVertex->right = NULL;
    
    return newVertex;
}

Graph *insertGraph(Graph *g, Vertex *v){
    if (g->head == NULL){
        g->head = v;
        return g;
    }
    
    v->left = g->head;
    g->head->right = v;
    g->head = v;
    
    
    return g;
}