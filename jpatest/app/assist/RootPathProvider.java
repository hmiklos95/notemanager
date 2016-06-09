package assist;

import com.google.inject.ImplementedBy;
import com.google.inject.Singleton;

@ImplementedBy(RootPathProviderImpl.class)
public interface RootPathProvider {
	public String getRootPath();
}	
