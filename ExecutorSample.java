import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ExecutorSample {

	public static void main(String[] args) {

		ExecutorService singleExec = Executors.newSingleThreadExecutor();
		singleExec.execute(() -> {

			System.out.println("Single thread Executor ");
		});

		System.out.println("Main thread");
		singleExec.shutdown();

		ExecutorService fixedThreadExec = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 1; i++) {

			Future future = fixedThreadExec.submit(() -> {

				System.out.println("Fixed pool thread Executor "
						+ Thread.currentThread().getId());
				return "Success";
			});

			try {

				System.out.println("Thread is not finished properly"
						+ future.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		System.out.println("Main thread continuing..");
		fixedThreadExec.shutdown();

		ScheduledExecutorService scheduler = Executors
				.newScheduledThreadPool(10);

		final ScheduledFuture<?> beeperHandle = scheduler.scheduleAtFixedRate(
				() -> {
					System.out.println("beep");
				}, 1, 5, TimeUnit.SECONDS);

	}
}
