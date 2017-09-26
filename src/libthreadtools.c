#include <stdlib.h>
#include <string.h>
#include <pthread.h>
#include <sys/types.h>
#include <sys/syscall.h>

#include <libthreadtools.h>

#define MIN(x,y) ((x)<(y)?(x):(y))

int tt_get_current_thread_id(void)
{
#if(0)
  /* https://stackoverflow.com/a/18709692 */
  pthread_t ptid = pthread_self();
  uint64_t threadId = 0;
  memcpy(&threadId, &ptid, MIN(sizeof(threadId), sizeof(ptid)));
  return threadId;
#endif

  /* https://stackoverflow.com/a/32211287 */
  return syscall(__NR_gettid);
}
