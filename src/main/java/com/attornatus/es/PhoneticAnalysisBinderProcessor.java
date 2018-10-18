package com.attornatus.es;

import org.elasticsearch.index.analysis.TokenFilterFactory;
import org.elasticsearch.indices.analysis.AnalysisModule.AnalysisProvider;
import org.elasticsearch.plugins.AnalysisPlugin;
import org.elasticsearch.plugins.Plugin;

import java.util.Map;
import static java.util.Collections.singletonMap;

public class PhoneticAnalysisBinderProcessor  extends Plugin implements AnalysisPlugin  {

    @Override
    public Map<String, AnalysisProvider<TokenFilterFactory>> getTokenFilters() {
        return singletonMap("foneticaportuguesa",  PhoneticTokenFilterFactory::new);
    }
}