#include <stdio.h>
#include <libthreadtools.h>


int main( int argc, char* argv[] )
{
  printf("current thread id: %d\n", tt_get_current_thread_id() );

  return 0;
}
